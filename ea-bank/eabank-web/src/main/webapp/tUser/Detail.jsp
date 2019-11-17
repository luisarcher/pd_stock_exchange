<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>TUser Detail</title>
            <link rel="stylesheet" type="text/css" href="/eabank-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>TUser Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="IdUser:"/>
                    <h:outputText value="#{tUser.TUser.idUser}" title="IdUser" />
                    <h:outputText value="Username:"/>
                    <h:outputText value="#{tUser.TUser.username}" title="Username" />
                    <h:outputText value="Passwd:"/>
                    <h:outputText value="#{tUser.TUser.passwd}" title="Passwd" />
                    <h:outputText value="Name:"/>
                    <h:outputText value="#{tUser.TUser.name}" title="Name" />
                    <h:outputText value="Nif:"/>
                    <h:outputText value="#{tUser.TUser.nif}" title="Nif" />
                    <h:outputText value="CreatedAt:"/>
                    <h:outputText value="#{tUser.TUser.createdAt}" title="CreatedAt" >
                        <f:convertDateTime pattern="MM/dd/yyyy" />
                    </h:outputText>

                    <h:outputText value="TAccountCollection:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty tUser.TUser.TAccountCollection}" value="(No Items)"/>
                        <h:dataTable value="#{tUser.TUser.TAccountCollection}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty tUser.TUser.TAccountCollection}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="IdAccount"/>
                                </f:facet>
                                <h:outputText value="#{item.idAccount}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Balance"/>
                                </f:facet>
                                <h:outputText value="#{item.balance}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="IdStatus"/>
                                </f:facet>
                                <h:outputText value="#{item.idStatus}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CreatedAt"/>
                                </f:facet>
                                <h:outputText value="#{item.createdAt}">
                                    <f:convertDateTime pattern="MM/dd/yyyy" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="IdUser"/>
                                </f:facet>
                                <h:outputText value="#{item.idUser}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{tAccount.detailSetup}">
                                    <f:param name="jsfcrud.currentTUser" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tUser.TUser][tUser.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tAccount.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="tUser" />
                                    <f:param name="jsfcrud.relatedControllerType" value="com.isec.eabank.jsf.TUserController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{tAccount.editSetup}">
                                    <f:param name="jsfcrud.currentTUser" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tUser.TUser][tUser.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tAccount.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="tUser" />
                                    <f:param name="jsfcrud.relatedControllerType" value="com.isec.eabank.jsf.TUserController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{tAccount.destroy}">
                                    <f:param name="jsfcrud.currentTUser" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tUser.TUser][tUser.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tAccount.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="tUser" />
                                    <f:param name="jsfcrud.relatedControllerType" value="com.isec.eabank.jsf.TUserController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{TUser.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentTUser" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tUser.TUser][tUser.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{TUser.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentTUser" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tUser.TUser][tUser.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{TUser.createSetup}" value="New TUser" />
                <br />
                <h:commandLink action="#{TUser.listSetup}" value="Show All TUser Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
