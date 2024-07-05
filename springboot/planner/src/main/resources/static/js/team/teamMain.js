const links = document.querySelectorAll('span[data-link]');

links.forEach(link => {
	link.addEventListener("click", function(){
		location.href=this.dataset.link+"?team_id="+this.closest('div').dataset.team_id;
	})
});