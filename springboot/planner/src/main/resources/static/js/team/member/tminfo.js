const team_id = document.querySelector('meta[name="team_id"]').content;
const member_id = document.querySelector('meta[name="member_id"]').content;
const header = document.querySelector('meta[name="_csrf_header"]').content;
const token = document.querySelector('meta[name="_csrf_token"]').content;
const form = document.getElementById("info_update");
const update_toggle = document.querySelectorAll(".update_toggle");
const update_btn = document.getElementById("update_btn");
const delete_btn = document.getElementById("delete");
const show = document.getElementById("show");
const hide = document.getElementById("hide");
const headers = new Headers();
headers.append('header',header);
headers.append('X-CSRF-Token',token);
if(show != null){
	// form 수정 토글
	update_toggle.forEach(toggle => {
		toggle.addEventListener("click", function(){
			if(show.style.display == 'block'){
				show.style.display = 'none';
				hide.style.display = 'block';
				form.tm_nickname.disabled = false;
			}else{
				show.style.display = 'block';
				hide.style.display = 'none';
				form.tm_nickname.disabled = true;
			}
		});
	})

	// form 수정 요청
	update_btn.addEventListener("click", function(){
		let update_request = new Request("/team/member/update", {
			method:'POST',
			body:new FormData(form)
		});
		fetch(update_request)
			.then(response => {
				if(response.ok){
					show.style.display = 'block';
					hide.style.display = 'none';
					form.tm_nickname.disabled = true;
				}else{
					alert('요청 실패');
				}
			})
	});
}

if(delete_btn != null){
	// 그룹 탈퇴 버튼
	delete_btn.addEventListener("click", function(){
		let data = new FormData();
		data.append('team_id', team_id);
		data.append('member_id', member_id);
		let del_request = new Request("/team/member/delete", {
			method:'DELETE',
			headers:headers,
			body:data,
			redirect:"follow"
		});
		fetch(del_request)
			.then(response => {
				if(response.ok){
					// 그룹 탈퇴 요청 성공시 redirect
					window.location.href = response.url;
				}else{
					alert("탈퇴 요청 실패");
				}
			})
		;
	});
}