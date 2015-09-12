/**
 * Common operations for Algorithm players.
 */
function Common() {}

Common.implementations = function(path,target) {
  $.getJSON('/' + path + '/implementations', function(data) {
	Monominoes.renders.DROPDOWN({
	  "btn-class": "btn-default",
	  "label": "Implementation to be used",
	  "placeholder": "Implementations",
	  "inline": true,
	  "id": "implementations",
	  "formatter": function(item) { return MonoUtils.format("{0} - {1}", item.className, item.description); },
	  "datakey": "implementation"
	}).render(data,target);
  });
};