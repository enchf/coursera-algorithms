/**
 * Union-Find player controller. 
 */
$(function() {
	Common.implementations("unionfind",$("#dropdown-group"));
	Common.prepareReset("unionfind","btn-reset","results");
	
	$("#btn-impl").click(function(event) {
	  var algorithm,size;
	  algorithm = "";
	  size = 10;
	  $.getJSON("/unionfind/init", {algorithm: algorithm, size: size}, function(data) {
		Common.appendStage("results",data);
	  });
	});
});