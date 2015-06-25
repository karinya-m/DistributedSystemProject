var maxSnapshots = 10;
var snapshotInterval = 2000;
var numSnapshot;
var tbl;


$(function() { // when document is ready
	$("#start").submit(pitInit);
	} );
	
function pitInit() {
  $("#initArea").empty();
  tbl = $("<table border=1 cellpadding=20>");

  numSnapshot = 0;
	try {
		$.get("PITinit",pitInitReply);
		return false;
	} catch (e) {
		console.log(e.description);
		$("#initArea").append(e.description);
		return false;
		}
} 

function pitInitReply(data) {
	$("#initArea").html(data.message);
	setTimeout(takeSnapshot, snapshotInterval);
	}

function takeSnapshot() {
  try {
	  $.get("PITsnapshot", pitSnapshotReply);
		if (++numSnapshot < maxSnapshots)
			setTimeout(takeSnapshot, snapshotInterval);
		return false;
	} catch (e) {
		console.log(e.description);
		$("#initArea").append(e.description);
		return false;
		}
}

function pitSnapshotReply(data) {
        if (data == "Snapshot Failed") {
            $(tbl).append("<tr><td>Snapshot Failed</td></tr>");
            $("#initArea").append(tbl);
            return;
        }
	var tr = $("<tr>");
	var passed = true;
	var x = [0, 4, 8];
	var check = "";
	for (var i in x) {
		var td = $("<td>");
		$(td).append($(data)[x[i]]);	
		$(td).append($(data)[x[i]+1]);
		$(tr).append(td);
		$(tbl).append(tr);
		check += $(tr).find("b").parent().next().html()
		}
		if (check == "999")
			$(tr).append("<td>Test "+numSnapshot+" passed</td>");
		else {
			$(tr).append("<td>Test "+numSnapshot+" FAILED</td>");
			passed = false;
			}
	$("#initArea").append(tbl);
	}
		