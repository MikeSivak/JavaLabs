<project name="ANaive" default = "copy" >
<target name="init">
    <echo message="Building ANaive Project" />
</target>
<target name="create" depends ="init">
    <delete dir="E:\Installers\apache-tomee-8.0.0-webprofile\apache-tomee-webprofile-8.0.0\webapps\ANative\" />
    <mkdir dir="E:\Installers\apache-tomee-8.0.0-webprofile\apache-tomee-webprofile-8.0.0\webapps\ANative\" />
    <mkdir dir="E:\Installers\apache-tomee-8.0.0-webprofile\apache-tomee-webprofile-8.0.0\webapps\ANative\html" />
    <mkdir dir="E:\Installers\apache-tomee-8.0.0-webprofile\apache-tomee-webprofile-8.0.0\webapps\ANative\images" />
    <mkdir dir="E:\Installers\apache-tomee-8.0.0-webprofile\apache-tomee-webprofile-8.0.0\webapps\ANative\WEB-INF" />
</target>

<target name="copy" depends ="create">
<!--    DESKTOP-K38K23S-->

    <war destfile="//DESKTOP-7TECNG5/webapps/A.war" webxml="web/WEB-INF/web.xml">
        <fileset dir="web"/>
        <lib dir="web/WEB-INF/lib"/>
        <classes dir="build/classes"/>
    </war>

<!--    <copy file="E:\4_course\Java\lab01\web\WEB-INF\web.xml"-->
<!--          todir="E:\Installers\apache-tomee-8.0.0-webprofile\apache-tomee-webprofile-8.0.0\webapps\ANative\WEB-INF\" />-->
<!--    <copy file="E:\4_course\Java\lab01\web\html/index.html"-->
<!--          todir="E:\Installers\apache-tomee-8.0.0-webprofile\apache-tomee-webprofile-8.0.0\webapps\ANative\" />-->
<!--    <copy file="E:\4_course\Java\lab01\web\images\hd-wallpapers-4k.jpg"-->
<!--          todir="E:\Installers\apache-tomee-8.0.0-webprofile\apache-tomee-webprofile-8.0.0\webapps\ANative\images\" />-->
</target>
</project>