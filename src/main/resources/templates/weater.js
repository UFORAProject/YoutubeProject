//weather.js
 
const weather = document.querySelector("#js_weather");
const now = document.querySelector(".now");
const status = document.querySelector(".status");
const maxmin = document.querySelector(".max_min_temp");
const feels = document.querySelector(".feel");
const weatherIcon = document.getElementById('icon');
const commentmessage = document.querySelector(".comment");

const COORDS = "coords";
const API_key = "ec1a6b926ab4ad92e04e244e2441e3d0";

function getWeather(lat, lng) {
    fetch(`http://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lng}&appid=${API_key}&units=metric`
    ).then(function (response) {
        return response.json();
    }).then(function (json) {
        const temperature = json.main.temp;
        const place = json.name;
        const hum = json.main.humidity;
        const iconid = json.weather[0].icon;
        const max = json.main.temp_max;
        const min = json.main.temp_min;
        const feel = json.main.feels_like;
        console.log(`http://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lng}&appid=${API_key}&units=metric`);
		 $.ajax({
		       url : 'englishToKorean.jsp?dong='+encodeURIComponent(place),
		      	type : 'GET',
		       	dataType : 'html',
		       	error : function(){
		       		console.log('error');
		       	},
		       	success : function(html){	
		        	weather.innerHTML = html;
		       	}
		   });
       	//weather.innerHTML = `${place}`
       	
        now.innerText = `현재 온도 : ${temperature}°C`
        maxmin.innerText = `최고 : ${max}°C / 최저 : ${min}°C `
        feels.innerText = `체감온도 ${feel}°C`
        weatherIcon.src = `https://openweathermap.org/img/wn/${iconid}@2x.png`
        status.innerText = `습도 : ${hum}%`
        if(iconid == "01d" || iconid == "01n"){
        	commentmessage.innerText = `날씨가 맑고 `
        	if(temperature >= 30){
        		commentmessage.innerText += ` 엄청 더우며`
        		if(hum >= 75){
        			commentmessage.innerText += ` 후덥지근하겠습니다.`
        		}
        		else if(hum < 75 && hum >= 50){
        			commentmessage.innerText += ` 습하겠습니다.`
        		}
        		else if(hum < 50 && hum >= 25){
        			commentmessage.innerText += ` 청량하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 매우 건조하겠습니다.`
        		}
        	}
        	else if(temperature <30 && temperature >= 20){
        		commentmessage.innerText += ` 다소 더우며`
        		if(hum >= 75){
        			commentmessage.innerText += ` 후덥지근하겠습니다.`
        		}
        		else if(hum < 75 && hum >= 50){
        			commentmessage.innerText += ` 습하겠습니다.`
        		}
        		else if(hum < 50 && hum >= 25){
        			commentmessage.innerText += ` 청량하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 매우 건조하겠습니다.`
        		}
        	}
        	else if(temperature <20 && temperature >= 10){
        		commentmessage.innerText += ` 쾌적하며`
        		if(hum >= 75){
        			commentmessage.innerText += ` 후덥지근하겠습니다.`
        		}
        		else if(hum < 75 && hum >= 50){
        			commentmessage.innerText += ` 습하겠습니다.`
        		}
        		else if(hum < 50 && hum >= 25){
        			commentmessage.innerText += ` 청량하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 매우 건조하겠습니다.`
        		}
        	}
        	else if(temperature <10 && temperature >= 0){
        		commentmessage.innerText += ` 쌀쌀하며`
        		if(hum >= 50){
        			commentmessage.innerText += ` 다소 습하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 엄청 건조하겠습니다.`
        		}
        	}
        	else{
        		commentmessage.innerText += ` 매우 추우며`
        		if(hum >= 50){
        			commentmessage.innerText += ` 다소 습하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 엄청 건조하겠습니다.`
        		}
        	}
        }
        else if(iconid == "02d" || iconid == "02n"){
        	commentmessage.innerText = `구름사이 햇빛이 쬐며 `
        	if(temperature >= 30){
        		commentmessage.innerText += ` 엄청 더우며`
        		if(hum >= 75){
        			commentmessage.innerText += ` 후덥지근하겠습니다.`
        		}
        		else if(hum < 75 && hum >= 50){
        			commentmessage.innerText += ` 습하겠습니다.`
        		}
        		else if(hum < 50 && hum >= 25){
        			commentmessage.innerText += ` 청량하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 매우 건조하겠습니다.`
        		}
        	}
        	else if(temperature <30 && temperature >= 20){
        		commentmessage.innerText += ` 다소 더우며`
        		if(hum >= 75){
        			commentmessage.innerText += ` 후덥지근하겠습니다.`
        		}
        		else if(hum < 75 && hum >= 50){
        			commentmessage.innerText += ` 습하겠습니다.`
        		}
        		else if(hum < 50 && hum >= 25){
        			commentmessage.innerText += ` 청량하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 매우 건조하겠습니다.`
        		}
        	}
        	else if(temperature <20 && temperature >= 10){
        		commentmessage.innerText += ` 쾌적하며`
        		if(hum >= 75){
        			commentmessage.innerText += ` 후덥지근하겠습니다.`
        		}
        		else if(hum < 75 && hum >= 50){
        			commentmessage.innerText += ` 습하겠습니다.`
        		}
        		else if(hum < 50 && hum >= 25){
        			commentmessage.innerText += ` 청량하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 매우 건조하겠습니다.`
        		}
        	}
        	else if(temperature <10 && temperature >= 0){
        		commentmessage.innerText += ` 쌀쌀하며`
        		if(hum >= 50){
        			commentmessage.innerText += ` 다소 습하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 엄청 건조하겠습니다.`
        		}
        	}
        	else{
        		commentmessage.innerText += ` 매우 추우며`
        		if(hum >= 50){
        			commentmessage.innerText += ` 다소 습하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 엄청 건조하겠습니다.`
        		}
        	}
        }
        else if(iconid == "03d" || iconid == "03n"){
        	commentmessage.innerText = `구름이 다소 있으나 `
        	if(temperature >= 30){
        		commentmessage.innerText += ` 엄청 더우며`
        		if(hum >= 75){
        			commentmessage.innerText += ` 후덥지근하겠습니다.`
        		}
        		else if(hum < 75 && hum >= 50){
        			commentmessage.innerText += ` 습하겠습니다.`
        		}
        		else if(hum < 50 && hum >= 25){
        			commentmessage.innerText += ` 청량하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 매우 건조하겠습니다.`
        		}
        	}
        	else if(temperature <30 && temperature >= 20){
        		commentmessage.innerText += ` 다소 더우며`
        		if(hum >= 75){
        			commentmessage.innerText += ` 후덥지근하겠습니다.`
        		}
        		else if(hum < 75 && hum >= 50){
        			commentmessage.innerText += ` 습하겠습니다.`
        		}
        		else if(hum < 50 && hum >= 25){
        			commentmessage.innerText += ` 청량하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 매우 건조하겠습니다.`
        		}
        	}
        	else if(temperature <20 && temperature >= 10){
        		commentmessage.innerText += ` 쾌적하며`
        		if(hum >= 75){
        			commentmessage.innerText += ` 후덥지근하겠습니다.`
        		}
        		else if(hum < 75 && hum >= 50){
        			commentmessage.innerText += ` 습하겠습니다.`
        		}
        		else if(hum < 50 && hum >= 25){
        			commentmessage.innerText += ` 청량하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 매우 건조하겠습니다.`
        		}
        	}
        	else if(temperature <10 && temperature >= 0){
        		commentmessage.innerText += ` 쌀쌀하며`
        		if(hum >= 50){
        			commentmessage.innerText += ` 다소 습하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 엄청 건조하겠습니다.`
        		}
        	}
        	else{
        		commentmessage.innerText += ` 매우 춥습니다.`
        		if(hum >= 50){
        			commentmessage.innerText += ` 다소 습하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 엄청 건조하겠습니다.`
        		}
        	}
        }
        else if(iconid == "04d" || iconid == "04n"){
        	commentmessage.innerText = `구름이 많이 끼어있고`
        	if(temperature >= 30){
        		commentmessage.innerText += ` 엄청 더우며`
        		if(hum >= 75){
        			commentmessage.innerText += ` 비가 올 수 도 있습니다.`
        		}
        		else if(hum < 75 && hum >= 50){
        			commentmessage.innerText += ` 습하겠습니다.`
        		}
        		else if(hum < 50 && hum >= 25){
        			commentmessage.innerText += ` 청량하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 매우 건조하겠습니다.`
        		}
        	}
        	else if(temperature <30 && temperature >= 20){
        		commentmessage.innerText += ` 다소 덥고`
        		if(hum >= 75){
        			commentmessage.innerText += ` 비가 올 수 도 있습니다.`
        		}
        		else if(hum < 75 && hum >= 50){
        			commentmessage.innerText += ` 습하겠습니다.`
        		}
        		else if(hum < 50 && hum >= 25){
        			commentmessage.innerText += ` 청량하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 매우 건조하겠습니다.`
        		}
        	}
        	else if(temperature <20 && temperature >= 10){
        		commentmessage.innerText += ` 쾌적하나`
        		if(hum >= 75){
        			commentmessage.innerText += ` 비가 올 수 도 있습니다.`
        		}
        		else if(hum < 75 && hum >= 50){
        			commentmessage.innerText += ` 습하겠습니다.`
        		}
        		else if(hum < 50 && hum >= 25){
        			commentmessage.innerText += ` 청량하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 매우 건조하겠습니다.`
        		}
        	}
        	else if(temperature <10 && temperature >= 0){
        		commentmessage.innerText += ` 쌀쌀하며`
        		if(hum >= 50){
        			commentmessage.innerText += ` 다소 습하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 엄청 건조하겠습니다.`
        		}
        	}
        	else{
        		commentmessage.innerText += ` 매우 춥고`
        		if(hum >= 50){
        			commentmessage.innerText += ` 눈이 내릴 수 도 있겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 엄청 건조하겠습니다.`
        		}
        	}
        }
        else if(iconid == "09d" || iconid == "09n"){
        	commentmessage.innerText = `비가 아주 많이 내리며 `
        	if(temperature >= 30){
        		commentmessage.innerText += ` 엄청 후덥지근하겠습니다.`
        	}
        	else if(temperature <30 && temperature >= 20){
        		commentmessage.innerText += ` 다소 덥겠습니다.`
        	}
        	else if(temperature <20 && temperature >= 10){
        		commentmessage.innerText += ` 시원한 날씨가 예상됩니다.`
        	}
        	else if(temperature <10 && temperature >= 0){
        		commentmessage.innerText += ` 쌀쌀하니 감기 조심하시길 바랍니다.`
        	}
        	else{
        		commentmessage.innerText += ` 눈이 올 수 도 있으니 조심하시길 바랍니다.`
        	}
        }
        else if(iconid == "10d" || iconid == "10n"){
        	commentmessage.innerText = `비가 살짝 내리며 `
        	if(temperature >= 30){
        		commentmessage.innerText += ` 엄청 덥겠습니다.`
        	}
        	else if(temperature <30 && temperature >= 20){
        		commentmessage.innerText += ` 다소 덥겠습니다.`
        	}
        	else if(temperature <20 && temperature >= 10){
        		commentmessage.innerText += ` 시원하겠습니다.`
        	}
        	else if(temperature <10 && temperature >= 0){
        		commentmessage.innerText += ` 쌀쌀하겠습니다.`
        	}
        	else{
        		commentmessage.innerText += ` 매우 춥습겠습니다.`
        	}
        }
        else if(iconid == "11d" || iconid == "11n"){
        	commentmessage.innerText = `천둥번개가 치며 `
        	if(temperature >= 30){
        		commentmessage.innerText += ` 엄청 덥겠습니다.`
        	}
        	else if(temperature <30 && temperature >= 20){
        		commentmessage.innerText += ` 다소 덥겠습니다.`
        	}
        	else if(temperature <20 && temperature >= 10){
        		commentmessage.innerText += ` 바람 조심하시길 바랍니다.`
        	}
        	else if(temperature <10 && temperature >= 0){
        		commentmessage.innerText += ` 강수 조심하시길 바랍니다.`
        	}
        	else{
        		commentmessage.innerText += ` 낙우 조심하시길 바랍니다.`
        	}
        }
        else if(iconid == "13d" || iconid == "13n"){
        	commentmessage.innerText = `눈이 내리며 눈길 조심하시길 바랍니다.`
        }
        else{
        	commentmessage.innerText = `안개가 있으며 `
        	if(temperature >= 30){
        		commentmessage.innerText += ` 엄청 더우며`
        		if(hum >= 75){
        			commentmessage.innerText += ` 후덥지근하겠습니다.`
        		}
        		else if(hum < 75 && hum >= 50){
        			commentmessage.innerText += ` 습하겠습니다.`
        		}
        		else if(hum < 50 && hum >= 25){
        			commentmessage.innerText += ` 청량하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 매우 건조하겠습니다.`
        		}
        	}
        	else if(temperature <30 && temperature >= 20){
        		commentmessage.innerText += ` 다소 더우며`
        		if(hum >= 75){
        			commentmessage.innerText += ` 후덥지근하겠습니다.`
        		}
        		else if(hum < 75 && hum >= 50){
        			commentmessage.innerText += ` 습하겠습니다.`
        		}
        		else if(hum < 50 && hum >= 25){
        			commentmessage.innerText += ` 청량하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 매우 건조하겠습니다.`
        		}
        	}
        	else if(temperature <20 && temperature >= 10){
        		commentmessage.innerText += ` 쾌적하나 시야 조심하시길 바라며`
        		if(hum >= 75){
        			commentmessage.innerText += ` 후덥지근하겠습니다.`
        		}
        		else if(hum < 75 && hum >= 50){
        			commentmessage.innerText += ` 습하겠습니다.`
        		}
        		else if(hum < 50 && hum >= 25){
        			commentmessage.innerText += ` 청량하겠습니다.`
        		}
        		else{
        			commentmessage.innerText += ` 매우 건조하겠습니다.`
        		}
        	}
        	else if(temperature <10 && temperature >= 0){
        		commentmessage.innerText += ` 쌀쌀하며 시야 조심하시길 바랍니다.`
        	}
        	else{
        		commentmessage.innerText += ` 매우 춥고 시야 조심하시길 바랍니다.`
        	}
        }
        
    })
}

function saveCoords(coordsObj) {
    localStorage.setItem(COORDS, JSON.stringify(coordsObj))
}

function handleGeoSuccess(position) {
    const latitude = position.coords.latitude;
    const longitude = position.coords.longitude;
    const coordsObj = {
        latitude,
        longitude
    }
    saveCoords(coordsObj)
    getWeather(latitude, longitude);
}

function handleGeoError() {
    console.log("Can't access geolocation");
}
function askForCoords() {
    navigator.geolocation.getCurrentPosition(handleGeoSuccess, handleGeoError);
    // navigator.geolocation.getCurrentPosition(success[, error[, [options]])
}

function loadCoords() {
    const loadedCoords = localStorage.getItem(COORDS);
    if (loadedCoords === null) {
        askForCoords();
    } else {
        const parseCoords = JSON.parse(loadedCoords);
        getWeather(parseCoords.latitude, parseCoords.longitude);
    }
}

function init() {
    loadCoords();
};
init();