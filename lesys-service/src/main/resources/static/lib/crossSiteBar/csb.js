;
(function () {
    var loaded = false;
    // data defination, the property of the item object will be set to the A element.
    // For example, if you want user click the link and open it in a new tab, you can set the value "_blank" to target property of the object.
    var data = [{
        text: "应用开放平台",
        href: "http://open.letv.cn/crm/",
        target: "_blank"
    }, {
        text: "手机应用商店",
        href: "http://10.154.28.32:8080/mstore_cms/",
        target: "_blank"
    }, {
        text: "电视应用商店",
        href: "http://115.182.94.54/?pvt=1",
        target: "_blank"
    }, {
        text: "电视游戏中心",
        href: "http://gc.letvstore.com/opman/home//",
        target: "_blank"
    }, {
        text: "SDK管理系统",
        href: "http://10.154.30.47:8081/admin/index",
        target: "_blank"
    }, {
        text: "手机应用统计系统",
        href: "http://10.185.29.113:8080/mstore_vstats/",
        target: "_blank"
    }, {
        text: "汽车应用商店",
        href: "http://lestoreauto.letv.cn/",
        target: "_blank"
    }, {
        text: "5.0电视应用商店",
        href: "http://106.38.226.20:8087/",
        target: "_blank"
    }, {
        text: "电视应用商店国际版",
        href: "http://10.185.28.208/",
        target: "_blank"
    }];
    // image url, change the value to real URL when you deploy it.
    var showArrowURL = "lib/crossSiteBar/show.png";
    var hideArrowURL = "lib/crossSiteBar/hide.png";
    // bind onready event
    if (document.addEventListener) {
        document.addEventListener("DOMContentLoaded", createCrossSiteBar, false);
        window.addEventListener("load", createCrossSiteBar, false);
    } else {
        document.attachEvent("onreadystatechange", createCrossSiteBar, false);
        window.attachEvent("load", createCrossSiteBar, false);
    }
    // create cross site bar element
    function createCrossSiteBar() {
        if (!loaded) {
            var csbContainer = document.createElement("div");
            csbContainer.id = "csbContainer";
            csbContainer.style.backgroundColor = "#000000";
            csbContainer.style.paddingLeft = "40px";
            csbContainer.style.width = "100%";
            csbContainer.style.position = "absolute";
            csbContainer.style.left = "0px";
            csbContainer.style.zIndex = 10000;
            document.body.appendChild(csbContainer);
            var toggle = document.createElement("div");
            toggle.style.backgroundImage = "url(" + showArrowURL + ")";
            toggle.style.width = "140px";
            toggle.style.height = "30px";
            toggle.style.position = "absolute";
            toggle.style.bottom = "-30px";
            toggle.style.left = "50%";
            toggle.style.marginLeft = "-70px";
            toggle.style.cursor = "pointer";
            csbContainer.appendChild(toggle);
            for (var i = 0; i < data.length; i++) {
                var item = document.createElement("a");
                for (var p in data[i]) {
                    if (data[i].hasOwnProperty(p)) {
                        if (p == "text") item.innerText = data[i][p];
                        else item.setAttribute(p, data[i][p] || '')
                    }
                }
                item.style.display = "block";
                item.style.float = "left";
                item.style.height = "40px";
                item.style.lineHeight = "40px";
                item.style.marginLeft = "10px";
                item.style.marginRight = "10px";
                item.style.textDecoration = "none";
                item.style.color = "#ffffff";
                csbContainer.appendChild(item);
            }
            csbContainer.style.top = "-" + csbContainer.clientHeight + "px";
            csbContainer.onclick = function (evt) {
                this.style.top = "-" + csbContainer.clientHeight + "px";
                toggle.style.backgroundImage = "url(" + showArrowURL + ")";
            }
            toggle.onclick = function (evt) {
                if (this.parentElement.style.top == "0px") {
                    this.parentElement.style.top = "-" + csbContainer.clientHeight + "px";
                    toggle.style.backgroundImage = "url(" + showArrowURL + ")";
                } else {
                    evt.stopPropagation();
                    this.parentElement.style.top = "0px";
                    toggle.style.backgroundImage = "url(" + hideArrowURL + ")";
                }
            }
        }
        loaded = true;
    }
})()
