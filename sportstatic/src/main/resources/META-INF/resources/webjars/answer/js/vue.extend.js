define(['vue'],function(Vue){
	var url = location.href;
	var answer = url.search('answer.html') != -1?true:false;
	var question = url.search('new_question.html') != -1?true:false;
	var top = url.search('top.html') != -1?true:false;
	var center = url.search('center.html') != -1 || url.search('my_questions.html') != -1 || url.search('my_listens.html') != -1 || url.search('center.html') != -1?true:false;
	var footnav = url.search('answer.html') != -1 || url.search('new_question.html') != -1 || url.search('top.html') != -1?true:false;
	/**
	 * [headNav description]
	 * @type {[type]}
	 */
	var headNav = Vue.extend({
	  template: '<nav class="nav-head"><a href="answer.html" v-bind:class="{curr: ' + answer + '}">热门问题</a><a href="new_question.html" v-bind:class="{curr: ' + question + '}">最新问题</a><a href="top.html" v-bind:class="{curr: ' + top + '}">才华排行</a></nav>'
	});

	/**
	 * [footNav description]
	 * @type {[type]}
	 */
	var footNav = Vue.extend({
	  template: '<nav class="nav-foot"><a href="answer.html" v-bind:class="{curr: ' + footnav + '}">问达</a><a href="">关注</a><a href="center.html" v-bind:class="{curr: ' + center + '}">我的</a></nav>'
	});

	/**
	 * 
	 */
	Vue.component('footer-nav', footNav);
	Vue.component('header-nav', headNav);
});