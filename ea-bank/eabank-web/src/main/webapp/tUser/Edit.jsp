<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing TUser</title>
            <link rel="stylesheet" type="text/css" href="/eabank-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing TUser</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="IdUser:"/>
                    <h:outputText value="#{tUser.TUser.idUser}" title="IdUser" />
                    <h:outputText value="Username:"/>
                    <h:inputText id="username" value="#{tUser.TUser.username}" title="Username" required="true" requiredMessage="The username field is required." />
                    <h:outputText value="Passwd:"/>
                    <h:inputText id="passwd" value="#{tUser.TUser.passwd}" title="Passwd" required="true" requiredMessage="The passwd field is required." />
                    <h:outputText value="Name:"/>
                    <h:inputText id="name" value="#{tUser.TUser.name}" title="Name" required="true" requiredMessage="The name field is required." />
                    <h:outputText value="Nif:"/>
                    <h:inputText id="nif" value="#{tUser.TUser.nif}" title="Nif" />
                    <h:outputText value="CreatedAt (MM/dd/yyyy):"/>
                    <h:inputText id="createdAt" value="#{tUser.TUser.createdAt}" title="CreatedAt" >
                        <f:convertDateTime pattern="MM/dd/yyyy" />
                    </h:inputText>
                    <h:outputText value="TAccountCollection:"/>
                    <h:selectManyListbox id="TAccountCollection" value="#{tUser.tUser.jsfcrud_transform[jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method.arrayToList].TAccountCollection}" title="TAccountCollection" size="6" converter="#{TAccount.converter}" >
                        <f:selectItems value="#{TAccount.TAccountItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{tUser.edit}" value="Save">
                    <f:param name="jsfcrud.currentTUser" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tUser.TUser][tUser.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{tUser.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentTUser" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tUser.TUser][tUser.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{tUser.listSetup}" value="Show All TUser Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
