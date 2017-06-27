/* Theme Name: Worthy - Free Powerful Theme by HtmlCoder
 * Author:HtmlCoder
 * Author URI:http://www.htmlcoder.me
 * Version:1.0.0
 * Created:November 2014
 * License: Creative Commons Attribution 3.0 License (https://creativecommons.org/licenses/by/3.0/)
 * File Description: Place here your custom scripts
 */

(function($){
    
    
    $.ajaxSetup({
	dataType:'json',
	cache: false,
	processData:false,
	serializeData:true,
	beforeSend:function(xhr,self){
	    if(typeof(self.data) === FormData){
		self.contentType = false
	    }else if(typeof(self.data) === 'object' && self.serializeData){
		self.contentType = 'application/x-www-form-urlencoded';
		self.data=$.param(self.data);
	    }
	}
    });
    $(document).ajaxStart(function(obj,self){
	
    });
    $.fn.serializeObj = function() {  
        var o = {};  
        var a = this.serializeArray();  
        $.each(a, function() {  
            if (o[this.name]) {  
                if (!o[this.name].push) {  
                    o[this.name] = [ o[this.name] ];  
                }  
                o[this.name].push(this.value || '');  
            } else {  
                o[this.name] = this.value || '';  
            }  
        });  
        return o;  
    }
})(this.jQuery);