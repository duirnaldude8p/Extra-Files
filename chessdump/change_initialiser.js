localStorage.setItem("Changer", "N");
localStorage.setItem("Counter", 0);

var binaryMatrix = "[[0,0,0],"+
					"[0,0,0],"+
					"[0,0,0]]";

var binaryArray = [0,0,1,0];
console.log("string bin: "+JSON.stringify(binaryArray).length);
localStorage.setItem("BinaryMatrix", binaryMatrix);
localStorage.setItem("BinaryArray", JSON.stringify(binaryArray));
