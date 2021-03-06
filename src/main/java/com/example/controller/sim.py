import sys
import pymysql
import numpy as np
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity


conn = pymysql.connect(host="ec2-3-36-62-144.ap-northeast-2.compute.amazonaws.com", 
                       user = "root", password = "park19960826", 
                       db = "project", charset = "utf8")
cur = conn.cursor()

#3단계: 광고주의 키워드 리스트를 받고 가장 많은 클러스터 추출
#4~5 단계: 클러스터 내 추천된 유료광고들과 같은 카테고리에 있는 채널 중 channel의 tag와 광고주의 키워드의 유사도 검사

def hash345(key_list, keylist):
    ###########
    tag_list = []
    url_list = []
    name_list = []
    img_list = []
    
    tail = "("
    for i in range(len(key_list)):
        key = key_list[i]
        tail += "hashtag LIKE '%"+ key + "%' OR descript LIKE '%" + key + "%'"
        if(i < len(key_list)-1):
            tail += " or "
    tail += ")"
    
    sel_3 = """
        SELECT clust,COUNT(*) AS count
        FROM channel A, advideo B
        WHERE A.ch_url = B.ch_url
        AND """ + tail + """
        group by clust
        order by count desc
        limit 0,1
        """
    cur.execute(sel_3)

    maxindex = 0
    while(True):
        row = cur.fetchone()
        if row == None:
            break
        maxindex = row[0]
    
    #######
    
    sel_4 = "SELECT ch_url, ch_name, img, tag FROM channel WHERE clust =" + str(maxindex) 
    cur.execute(sel_4)
    
    while(True):
        row = cur.fetchone()
        if row == None:
            break
        url_list.append(row[0])
        name_list.append(row[1])
        img_list.append(row[2])
        tag_list.append(row[3])
    
    result = [[] for i in range(len(tag_list))]
        
    for i in range(len(tag_list)):    
        sent = (keylist, tag_list[i])
        tfidf_vect_simple = TfidfVectorizer()
        tfidf_matrix= tfidf_vect_simple.fit_transform(sent)
        cs = cosine_similarity(tfidf_matrix[0:1],tfidf_matrix[1:2])
        sim = round(cs[0][0] * 100, 4)
        result[i].append(url_list[i])
        result[i].append(name_list[i])
        result[i].append(img_list[i])
        result[i].append(sim)
    
    result.sort(key=lambda x: -x[3])
    
    answer = result[:4]     #보여줄 범위 선택하세요..
        
    return answer

keyword = ''
for i in range(1,len(sys.argv)):
    keyword += sys.argv[i]
    keyword += ' '
keyword_array = keyword.split(' ')


print(hash345(keyword_array, keyword))
###