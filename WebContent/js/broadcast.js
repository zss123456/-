var oPic = document.getElementById("pic");
var oTab = document.getElementById("tab");
var oLi = oTab.getElementsByTagName("li");
var prev = document.getElementsByClassName("slider-prev")[0];
var next = document.getElementsByClassName("slider-next")[0];
var num = 0;
oLi[0].className = "on";

for(var i = 0;i<oLi.length;i++) {
    oLi[i].index = i;
    oLi[i].onclick =function(){
        oLi[num].className = "";
        num = this.index;
        oLi[num].className = "on";
        move(oPic,{left: -1300*(num+1)});
    }
}
prev.onclick = function(){
    oLi[num].className = "";
    num--;
    if(num<0) {
        num = oLi.length - 1;
        oPic.style.left = -1300*(oLi.length+1) + "px";
    }
    oLi[num].className = "on";
    move(oPic,{left: -1300*(num+1)});
}

next.onclick = function(){
    oLi[num].className = "";
    num++;
    if(num == oLi.length) {
        num = 0;
        oPic.style.left =  0;
    }
    oLi[num].className = "on";
    move(oPic,{left: -1300*(num+1)});
}

setInterval(function(){
    oLi[num].className = "";
    num++;
    if(num == oLi.length) {
        num = 0;
        oPic.style.left =  0;
    }
    oLi[num].className = "on";
    move(oPic,{left: -1300*(num+1)});
},4000);