
function openNaver(shcode){
	var url = "http://finance.naver.com/item/main.nhn?code=" + shcode;
    window.open(url, "네이버새창", "toolbar=no, menubar=no, scrollbars=no, resizable=yes" ); 
    return;
}  
  

function moveUpjong(path, date, gubun, upcode, duration){
	var url = path + "/upjong/rising_falling_kospi?basedate=" + date + "&upcode=" + upcode + "&duration=" + duration;

	if (gubun == '2') 
		url = path + "/upjong/rising_falling_kosdaq?basedate=" + date + "&upcode=" + upcode + "&duration=" + duration;
    location.href(url);  

} 

function closeWin() {
    //window.opener.location.href = URL;
    window.close();
}

// amt = commaNum(amt)  
// 1000000 => 1,000,000  
function commaNum(x) {  
	 return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
} 
