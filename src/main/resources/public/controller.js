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
		  "path": "players",
		  "render": Monominoes.renders.LIST_GROUP({
			"item-render": function(item,list) {
			  var li = MonoUtils.getTag(Monominoes.tags.LI)
			  	.addClass(this["item-class"]).appendTo(list);
			  return Monominoes.renders.A({ 
				"href": item.link,
				"formatter": function(item) { return item.name + " - " + item.description; }
			  }).render(item,li);
			}
		  })
		}]
	  }
	});
  });
});