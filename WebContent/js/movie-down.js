function fall() {
    var oFather = document.getElementsByClassName("father");
    var oChild = document.getElementsByClassName("child");
    var i,len,num;
    for(i = 0,len = oFather.length;i < len;i++) {
        oFather[i].index = i;
        oFather[i].onmouseenter = function() {
            num = this.index;
            oChild[num].style.transition = 0.3+"s";
            oChild[num].style.top = 0;
            this.onmouseleave = function() {
                oChild[num].style.top = -224 + "px";
                oChild[num].style.transition = 0.2 + "s";
            }
        }
    }
}
fall();