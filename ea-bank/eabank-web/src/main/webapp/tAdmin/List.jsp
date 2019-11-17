<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing TAdmin Items</title>
            <link rel="stylesheet" type="text/css" href="/eabank-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing TAdmin Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No TAdmin Items Found)<br />" rendered="#{tAdmin.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{tAdmin.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{tAdmin.pagingInfo.firstItem + 1}..#{tAdmin.pagingInfo.lastItem} of #{tAdmin.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tAdmin.prev}" value="Previous #{tAdmin.pagingInfo.batchSize}" rendered="#{tAdmin.pagingInfo.firstItem >= tAdmin.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{tAdmin.next}" value="Next #{tAdmin.pagingInfo.batchSize}" rendered="#{tAdmin.pagingInfo.lastItem + tAdmin.pagingInfo.batchSize <= tAdmin.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tAdmin.next}" value="Remaining #{tAdmin.pagingInfo.itemCount - tAdmin.pagingInfo.lastItem}"
                                   rendered="#{tAdmin.pagingInfo.lastItem < tAdmin.pagingInfo.itemCount && tAdmin.pagingInfo.lastItem + tAdmin.pagingInfo.batchSize > tAdmin.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{tAdmin.TAdminItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="IdAdmin"/>
                            </f:facet>
                            <h:outputText value="#{item.idAdmin}"/>
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
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{tAdmin.detailSetup}">
                                <f:param name="jsfcrud.currentTAdmin" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tAdmin.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{tAdmin.editSetup}">
                                <f:param name="jsfcrud.currentTAdmin" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tAdmin.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{tAdmin.remove}">
                                <f:param name="jsfcrud.currentTAdmin" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tAdmin.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{tAdmin.createSetup}" value="New TAdmin"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
