<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>TAdmin Detail</title>
            <link rel="stylesheet" type="text/css" href="/eabank-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>TAdmin Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="IdAdmin:"/>
                    <h:outputText value="#{tAdmin.TAdmin.idAdmin}" title="IdAdmin" />
                    <h:outputText value="Username:"/>
                    <h:outputText value="#{tAdmin.TAdmin.username}" title="Username" />
                    <h:outputText value="Passwd:"/>
                    <h:outputText value="#{tAdmin.TAdmin.passwd}" title="Passwd" />


                </h:panelGrid>
                <br />
                <h:commandLink action="#{TAdmin.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentTAdmin" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAdmin.TAdmin][tAdmin.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{TAdmin.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentTAdmin" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAdmin.TAdmin][tAdmin.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{TAdmin.createSetup}" value="New TAdmin" />
                <br />
                <h:commandLink action="#{TAdmin.listSetup}" value="Show All TAdmin Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
