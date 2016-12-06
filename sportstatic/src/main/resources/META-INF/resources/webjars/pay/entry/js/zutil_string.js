var zutil_string = {

	temp : {

		EMPTY : "",
		INDEX_NOT_FOUND : -1
	},

	isEmpty : function(cs) {
		return cs == undefined || cs == null || cs.length == 0;
	},
	substringAfterLast : function(str, separator) {
		if (this.isEmpty(str)) {
			return str;
		}
		if (this.isEmpty(separator)) {
			return this.temp.EMPTY;
		}
		var pos = str.lastIndexOf(separator);
		if (pos == this.temp.INDEX_NOT_FOUND
				|| pos == str.length - separator.length) {
			return this.temp.EMPTY;
		}
		return str.substring(pos + separator.length);
	},
	contains:function(seq, searchSeq)
	{
		return seq.indexOf(searchSeq)>this.temp.INDEX_NOT_FOUND;
	}

};