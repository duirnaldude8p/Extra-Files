var foo = new robot();
// console.log("hello");
function theRobot(){
    var newVal3 = localStorage.getItem('hasChanged');
    console.log(" in master: "+newVal3);
    if(newVal3=='Y'){
        // foo.select('bpawn4');
        // foo.moveTo('r5D');

        // foo.select('bhorse1');
        // foo.moveTo('r6A');

        // // foo.select('bpawn8');
        // // foo.moveTo('r6H');

        // foo.select('bqueen');
        // foo.moveTo('r7D');

        // foo.select('bpawn2');
        // foo.moveTo('r5B');

        // foo.select('bpawn3');
        // foo.moveTo('r5C');

        // // foo.select('bqueen');
        // // foo.moveTo('r6C');

        // foo.select('bbishop1');
        // foo.moveTo('r7B');
        
       
        // foo.castleMoveL();

        // foo.castleMoveR();

        // foo.select('bpawn1');
        // foo.moveTo('r6A');

        // foo.select('bpawn1');
        // foo.moveTo('r5A');

        foo.select('bpawn5');
        foo.moveTo('r5E');

        foo.select('bhorse2');
        foo.moveTo('r6H');

        foo.select('bbishop2');
        foo.moveTo('r6D');

        foo.select('bpawn6');
        foo.moveTo('r6F');


        foo.castleMoveR();


        foo.select('bpawn5');
        foo.moveTo('r5E');

        foo.select('bpawn6');
        foo.moveTo('r6F');

        foo.select('bpawn6');
        foo.moveTo('r5F');

 //     foo.select('brook1');
 //     foo.moveTo('r5G');
    }
}
// theRobot();
setInterval(theRobot, 500);
function movement(){
    //var foo2 = new robot();
    var newVal4= localStorage.getItem('hasChanged');
    if(newVal4=='Y'){
        foo.kingMovement("bking");
    }
}   