//var newVal3 = localStorage.getItem('hasChanged');
//console.log(" in puppet master: "+newVal3);
var foo = new robot();

function theRobot(){
	var newVal3 = localStorage.getItem('hasChanged');
	//console.log(" in master: "+newVal3);
    if(newVal3=='Y'){
		foo.select('bpawn5');
		foo.moveTo('r6E');

		foo.select('bpawn2');
		foo.moveTo('r6B');

		foo.select('bbishop1');
		foo.moveTo('r6A');
		// foo.select('bbishop1');
		// foo.moveTo('r7D');
	
		// foo.select('bbishop1');
		// foo.moveTo('r6E');

		foo.select('bpawn8');
    	foo.moveTo('r6H');

    	foo.select('bpawn7');
    	foo.moveTo('r6G');

	}
}
function movement(){
	//var foo2 = new robot();
	var newVal4= localStorage.getItem('hasChanged');
	if(newVal4=='Y'){
		foo.kingMovement("bking");
	}
}	

var movecheck = false;
var start = false;
var movdone = false;

if(!start||movdone){
	setInterval(movement, 50);
	movecheck = true;
	start = true;
	if(movecheck){
		setInterval(theRobot, 3000);
		movdone = true;		
	}
}
//}

