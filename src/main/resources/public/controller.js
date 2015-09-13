/**
 * Controller for the main screen of the Algorithm player.
 */
$(function() {
  $.getJSON("players",function(data) {
	Monominoes.build({
	  "data": data,
	  "target": "list-container",
	  "layout": {
		"elements": [{
		  "path": "title",
		  "render": Monominoes.renders.H1
		},{
		  "path": "list",
		  "render": Monominoes.renders.LIST_GROUP({
			"formatter": function(item) {
			  return Monominoes.render.A({
				"href": item.url,
				"formatter": function(item) { return item.description; }
			  }).render(item);
			}
		  })
		}]
	  }
	});
  });
});