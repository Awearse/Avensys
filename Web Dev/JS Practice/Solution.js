//Fibonacci
document.write("Fibonacci:","<br>");

let n1 = 0, n2 = 1, nestTerm;

for(let i=1;i<11;i++){
    document.write(n1);
    if(i!=10){
        document.write(", ");
    }
    nextTerm = n1 +n2;
    n1 =n2;
    n2 = nextTerm;
}
document.write("<br><br>")

//Table of 8
document.write("Table of 8:","<br>");

var count = 1;
while(count<11){
    document.write("8 x "+count+" = "+count*8+"<br>");
    count++;
}
document.write("<br>");

//Sort an Array
document.write("Sorting an Array:","<br>");
var arr1 = [3,8,7,6,5,-4,3,2,1];

function sort(arr){
    return arr.sort(function(a, b){return a-b});
}

document.write(sort(arr1),"<br><br>");

//Printing 2d Array
document.write("Printing 2d Array:","<br>");
var a =[[1,2,1,24],[8,11,9,4],[7,0,7,27],[7,4,28,14],[3,10,26,7]];

for(var i=0;i<5;i++){
    document.write("row "+i,"<br>");
    for(var j=0;j<4;j++){
        document.write(a[i][j],"<br>");
    }
}