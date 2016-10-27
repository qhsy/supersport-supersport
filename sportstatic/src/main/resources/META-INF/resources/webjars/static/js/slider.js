function Slider(opts) {
	this.wrap = opts.dom;
	this.list = opts.list;
	this.idx = opts.index || 0;
	this.init();
	this.renderDOM();
	this.bindDOM();
	this.goIndex(opts.index);
}
Slider.prototype.init = function() {
	this.radio = window.innerHeight / window.innerWidth;
	this.scaleW = window.innerWidth;
};
Slider.prototype.renderDOM = function() {
	var wrap = this.wrap;
	var data = this.list;
	var len = data.length;

	this.outer = document.createElement('ul');
	for (var i = 0; i < len; i++) {
		var li = document.createElement('li');
		var item = data[i];
		li.style.width = window.innerWidth + 'px';
		li.style.webkitTransform = 'translate3d(' + i * this.scaleW + 'px, 0, 0)';
		if (item) {
			if (item['height'] / item['width'] > this.radio) {
				li.innerHTML = '<img height="' + window.innerHeight + '" src="' + item['img'] + '">';
			} else {
				li.innerHTML = '<img width="' + window.innerWidth + '" src="' + item['img'] + '">';
			}
		}
		this.outer.appendChild(li);
	}
	this.outer.style.cssText = 'width:' + this.scaleW + 'px';

	wrap.style.height = window.innerHeight + 'px';
	wrap.appendChild(this.outer);
};
Slider.prototype.goIndex = function(n) {
	var idx = this.idx;
	var lis = this.outer.getElementsByTagName('li');
	var len = lis.length;
	var cidx;
	if (typeof n == 'number') {
		cidx = idx;
	} else if (typeof n == 'string') {
		cidx = idx + n * 1;
	}
	if (cidx > len - 1) {
		cidx = len - 1;
	} else if (cidx < 0) {
		cidx = 0;
	}
	this.idx = cidx;
	lis[cidx].style.webkitTransition = '-webkit-transform 0.2s ease-out';
	lis[cidx - 1] && (lis[cidx - 1].style.webkitTransition = '-webkit-transform 0.2s ease-out');
	lis[cidx + 1] && (lis[cidx + 1].style.webkitTransition = '-webkit-transform 0.2s ease-out');
	lis[cidx].style.webkitTransform = 'translate3d(0, 0, 0)';
	lis[cidx - 1] && (lis[cidx - 1].style.webkitTransform = 'translate3d(-' + this.scaleW + 'px, 0, 0)');
	lis[cidx + 1] && (lis[cidx + 1].style.webkitTransform = 'translate3d(' + this.scaleW + 'px, 0, 0)');

	for(var i=0; i<len; i++){
		lis[i].className = '';
	}
	lis[cidx].className = 'curr';
};
Slider.prototype.bindDOM = function() {
	var self = this;
	var scaleW = self.scaleW;
	var outer = self.outer;
	var len = self.list.length;
	var startHandler = function(evt) {
		self.startTime = new Date() * 1;
		self.startX = evt.touches[0].pageX;
		self.offsetX = 0;
		var target = evt.target;
		while (target.nodeName != 'LI' && target.nodeName != 'BODY') {
			target = target.parentNode;
		}
		self.target = target;

	};
	var moveHandler = function(evt) {
		evt.preventDefault();
		self.offsetX = evt.targetTouches[0].pageX - self.startX;
		var lis = outer.getElementsByTagName('li');
		var i = self.idx - 1;
		var m = i + 3;
		for (i; i < m; i++) {
			lis[i] && (lis[i].style.webkitTransition = '-webkit-transform 0s ease-out');
			lis[i] && (lis[i].style.webkitTransform = 'translate3d(' + ((i - self.idx) * self.scaleW + self.offsetX) + 'px, 0, 0)');
		}
	};
	var endHandler = function(evt) {
		evt.preventDefault();
		var boundary = scaleW / 6;
		var endTime = new Date() * 1;
		var lis = outer.getElementsByTagName('li');
		if (endTime - self.startTime > 300) {
			if (self.offsetX >= boundary) {
				self.goIndex('-1');
			} else if (self.offsetX < 0 && self.offsetX < -boundary) {
				self.goIndex('+1');
			} else {
				self.goIndex('0');
			}
		} else {
			if (self.offsetX > 50) {
				self.goIndex('-1');
			} else if (self.offsetX < -50) {
				self.goIndex('+1');
			} else {
				self.goIndex('0');
			}
		}
	};
	outer.addEventListener('touchstart', startHandler);
	outer.addEventListener('touchmove', moveHandler);
	outer.addEventListener('touchend', endHandler);
};