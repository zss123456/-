function move(obj,json) {
    clearInterval(obj.timer);
    obj.timer = setInterval(function() {
        var bStop = true;
        for(var attr in json) {
            cur = parseInt(getStyle(obj,attr));
            var speed = (json[attr] - cur) / 10;
            speed = speed > 0 ? Math.ceil(speed) : Math.floor(speed);
            if(cur != json[attr]) bStop = false;
            obj.style[attr] = cur + speed + "px";
        }
        if(bStop) {
            clearInterval(obj.timer);
        }
    },30);
};
function getStyle(obj,attr) {
    return obj.currentStyle ? obj.currentStyle[attr] : getComputedStyle(obj)[attr];
}
