<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing TAccount</title>
            <link rel="stylesheet" type="text/css" href="/eabank-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing TAccount</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="IdAccount:"/>
                    <h:outputText value="#{tAccount.TAccount.idAccount}" title="IdAccount" />
                    <h:outputText value="Balance:"/>
                    <h:inputText id="balance" value="#{tAccount.TAccount.balance}" title="Balance" />
                    <h:outputText value="IdStatus:"/>
                    <h:inputText id="idStatus" value="#{tAccount.TAccount.idStatus}" title="IdStatus" />
                    <h:outputText value="CreatedAt (MM/dd/yyyy):"/>
                    <h:inputText id="createdAt" value="#{tAccount.TAccount.createdAt}" title="CreatedAt" >
                        <f:convertDateTime pattern="MM/dd/yyyy" />
                    </h:inputText>
                    <h:outputText value="TMovementCollection:"/>
                    <h:selectManyListbox id="TMovementCollection" value="#{tAccount.tAccount.jsfcrud_transform[jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method.arrayToList].TMovementCollection}" title="TMovementCollection" size="6" converter="#{TMovement.converter}" >
                        <f:selectItems value="#{TMovement.TMovementItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="IdUser:"/>
                    <h:selectOneMenu id="idUser" value="#{tAccount.TAccount.idUser}" title="IdUser" >
                        <f:selectItems value="#{TUser.TUserItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{tAccount.edit}" value="Save">
                    <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAccount.TAccount][tAccount.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{tAccount.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAccount.TAccount][tAccount.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{tAccount.listSetup}" value="Show All TAccount Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
