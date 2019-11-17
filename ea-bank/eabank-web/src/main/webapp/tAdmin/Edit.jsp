<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing TAdmin</title>
            <link rel="stylesheet" type="text/css" href="/eabank-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing TAdmin</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="IdAdmin:"/>
                    <h:outputText value="#{tAdmin.TAdmin.idAdmin}" title="IdAdmin" />
                    <h:outputText value="Username:"/>
                    <h:inputText id="username" value="#{tAdmin.TAdmin.username}" title="Username" />
                    <h:outputText value="Passwd:"/>
                    <h:inputText id="passwd" value="#{tAdmin.TAdmin.passwd}" title="Passwd" />

                </h:panelGrid>
                <br />
                <h:commandLink action="#{tAdmin.edit}" value="Save">
                    <f:param name="jsfcrud.currentTAdmin" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAdmin.TAdmin][tAdmin.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{tAdmin.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentTAdmin" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAdmin.TAdmin][tAdmin.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{tAdmin.listSetup}" value="Show All TAdmin Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
