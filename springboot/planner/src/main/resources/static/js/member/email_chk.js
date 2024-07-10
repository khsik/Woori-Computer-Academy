$(function() { // $(document).ready(function(){}); 와 같음
	$("#emailChkBox").addClass("disabled-uncheck");

	// 새로고침 시 물어보기 ==== 크롬에서는 보안상 물어보는 메세지를 바꿀수없음
	$(window).on('beforeunload', () => {
		return null;
	});

	// 폼 제출 시 플래그 설정
	$(".insertForm").on("submit", () => {
		$(window).off('beforeunload');
	});

	// 이메일 전송요청
	const sendEmail = (toEmail, type, modalId=null) => {
		if (isNull(toEmail)) {
			alert("이메일을 입력해주세요");
			return;
		}
		const ajaxObj = {
			url: API_LIST.EMAIL_SEND,
			method: "post",
			param: {
				toEmail: toEmail,
				type: type
			},
			successFn: () => {
				alert("인증 코드가 해당 이메일로 전송되었습니다.");
				if (!isNull(modalId)) {
					openModal(modalId);
				}
			}
		};
		ajaxCall(ajaxObj);
	}
	// 이메일 인증 버튼 클릭시
	$(".emailChkBtn").click(() => {
		const toEmail = $("#email").val();
		const type = $("#type").val();
		$(".emailChkBtn").prop("disabled",true);
		$("#email").attr("readonly", true);
		sendEmail(toEmail, type, "authCodeModal");
	});

	// 인증번호 재선송 버튼 클릭 시
	$(".resendBtn").click(() => {
		const toEmail = $("#email").val();
		const type = $("#type").val();
		sendEmail(toEmail, type);
	});

	$(".Xbtn").click(() =>{
		$(".emailChkBtn").prop("disabled",false);
	});

	// 인증 완료 버튼 눌렀을시
	$(".codeChkBtn").click(() => {
		const toEmail = $("#email").val();
		const authCode = $("#inputCode").val();
		const type = $("#type").val();
		$(".emailChkBtn").prop("disabled",false);
		if (isNull(authCode)) {
			alert("인증코드를 입력해주세요");
			return;
		}
		const ajaxObj = {
			url: API_LIST.AUTH_CODE_CHK,
			method: "post",
			param: {
				toEmail: toEmail,
				authCode: authCode
			},
			successFn: (data) => {
				if (!isNull(data)) {
					alert("인증되었습니다.");
					closeModal("authCodeModal");
					if (type === "findPw") {
						alert("보안을위해 비밀번호 변경 페이지로 이동됩니다.");
						$(window).off('beforeunload');
						location.href = PAGE_LIST.CHANGE_PASSWORD_FORM + data;
					}
					$("#emailChkBox").prop("checked", true);
					$("#emailChkBox").addClass("disabled-checkbox");
				}
			}
		};
		ajaxCall(ajaxObj);
	});
});