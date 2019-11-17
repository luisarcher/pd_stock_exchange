<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New TMovement</title>
            <link rel="stylesheet" type="text/css" href="/eabank-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New TMovement</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{tMovement.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
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
                <h:commandLink action="#{tMovement.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{TMovement.listSetup}" value="Show All TMovement Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
