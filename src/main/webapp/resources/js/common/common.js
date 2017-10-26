function changeVerifyCode(img){
	console.log(img);
	img.src = "../Kaptcha?" + Math.floor(Math.random()*100);
}