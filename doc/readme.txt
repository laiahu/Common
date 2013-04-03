Why this "No Session found for current thread" exceptions in spring 3.1 and hibernate 4

在配置文件中加上:
<tx:advice id="txAdvice" transaction-manager="txManager">
    <tx:attributes>
        <tx:method name="get*" read-only="true" propagation="REQUIRED"/>
        <tx:method name="*" propagation="REQUIRED"/>
    </tx:attributes>
</tx:advice>