<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing TUser Items</title>
            <link rel="stylesheet" type="text/css" href="/eabank-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing TUser Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No TUser Items Found)<br />" rendered="#{tUser.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{tUser.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{tUser.pagingInfo.firstItem + 1}..#{tUser.pagingInfo.lastItem} of #{tUser.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tUser.prev}" value="Previous #{tUser.pagingInfo.batchSize}" rendered="#{tUser.pagingInfo.firstItem >= tUser.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{tUser.next}" value="Next #{tUser.pagingInfo.batchSize}" rendered="#{tUser.pagingInfo.lastItem + tUser.pagingInfo.batchSize <= tUser.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tUser.next}" value="Remaining #{tUser.pagingInfo.itemCount - tUser.pagingInfo.lastItem}"
                                   rendered="#{tUser.pagingInfo.lastItem < tUser.pagingInfo.itemCount && tUser.pagingInfo.lastItem + tUser.pagingInfo.batchSize > tUser.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{tUser.TUserItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="IdUser"/>
                            </f:facet>
                            <h:outputText value="#{item.idUser}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Username"/>
                            </f:facet>
                            <h:outputText value="#{item.username}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Passwd"/>
                            </f:facet>
                            <h:outputText value="#{item.passwd}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Name"/>
                            </f:facet>
                            <h:outputText value="#{item.name}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Nif"/>
                            </f:facet>
                            <h:outputText value="#{item.nif}"/>
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
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{tUser.detailSetup}">
                                <f:param name="jsfcrud.currentTUser" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tUser.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{tUser.editSetup}">
                                <f:param name="jsfcrud.currentTUser" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tUser.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{tUser.remove}">
                                <f:param name="jsfcrud.currentTUser" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tUser.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{tUser.createSetup}" value="New TUser"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
