<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing TMovement</title>
            <link rel="stylesheet" type="text/css" href="/eabank-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing TMovement</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="IdMovement:"/>
                    <h:outputText value="#{tMovement.TMovement.idMovement}" title="IdMovement" />
                    <h:outputText value="Description:"/>
                    <h:inputText id="description" value="#{tMovement.TMovement.description}" title="Description" />
                    <h:outputText value="Val:"/>
                    <h:inputText id="val" value="#{tMovement.TMovement.val}" title="Val" />
                    <h:outputText value="FinalBalance:"/>
                    <h:inputText id="finalBalance" value="#{tMovement.TMovement.finalBalance}" title="FinalBalance" />
                    <h:outputText value="CreatedAt (MM/dd/yyyy):"/>
                    <h:inputText id="createdAt" value="#{tMovement.TMovement.createdAt}" title="CreatedAt" >
                        <f:convertDateTime pattern="MM/dd/yyyy" />
                    </h:inputText>
                    <h:outputText value="IdAccount:"/>
                    <h:selectOneMenu id="idAccount" value="#{tMovement.TMovement.idAccount}" title="IdAccount" >
                        <f:selectItems value="#{TAccount.TAccountItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{tMovement.edit}" value="Save">
                    <f:param name="jsfcrud.currentTMovement" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tMovement.TMovement][tMovement.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{tMovement.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentTMovement" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tMovement.TMovement][tMovement.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{tMovement.listSetup}" value="Show All TMovement Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
