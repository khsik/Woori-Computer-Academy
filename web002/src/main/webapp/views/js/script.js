function writeCheck(){
	if(document.writeform.writer.value==''){
		alert("작성자를 입력해주세요.");
		document.writeform.writer.focus();
		return false;
	}
	if(document.writeform.title.value == ''){
		alert("제목을 입력해주세요.");
		document.writeform.title.focus();
		return false;
	}
}