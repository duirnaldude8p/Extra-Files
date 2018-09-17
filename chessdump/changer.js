function changer(){
	this.changeToN = function(){
		var item = localStorage.getItem("Changer");
		if(item=="Y"){
			localStorage.setItem("Changer", "N");
		}
	}
}