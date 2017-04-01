<%@ page import="models.modules.Module"%>
<%@ page import="java.util.Collection"%>
<%
	final Collection<Module> modules = (Collection<Module>) request.getAttribute("modules");
	final boolean containsWebcam = modules.contains(Module.WEBCAM);
%>
<div class="col-sm-12">
	<button class="btn btn-success btn-lg btn-block<%=containsWebcam ? "" : " disabled"%>">
		Capture Image <span class="glyphicon glyphicon-cloud-upload"></span>
	</button>
	<button class="btn btn-default btn-lg btn-block<%=containsWebcam ? "" : " disabled"%>">
		FullScreen <span class="glyphicon glyphicon-fullscreen"></span>
	</button>
</div>