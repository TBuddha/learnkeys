package annotation.编译时处理;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Set;

/**
 * @author zhoutao
 * @date 2019/6/21 16:21
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
// 指定可处理@Persistent @Id @三个Annotation
@SupportedAnnotationTypes({"Persistent", "Id", "Property"})
public class HibernateAnnotationProcessor extends AbstractProcessor {
  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    // 生产额外文件
    PrintStream ps = null;
    try {
      for (Element t : roundEnv.getElementsAnnotatedWith(Persistent.class)) {
        Name className = t.getSimpleName();
        Persistent persistent = t.getAnnotation(Persistent.class);
        ps = new PrintStream(new FileOutputStream(className + ".hbm.xml"));
        // 执行输出
        ps.println("<?xml version=\"构建器.0\"?>");
        ps.println("<!DOCTYPE hibernate-mapping");
        ps.println("	PUBLIC \"-//Hibernate/Hibernate Mapping DTD 3.0//EN\"");
        ps.println("    \"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd\">");
        ps.println("<hibernate-mapping>");
        ps.print("	<class name=\"" + t);
        // 输出per的table()的值
        ps.println("\" table=\"" + persistent.table() + "\">");

        for (Element f : t.getEnclosedElements()) {
          // 只处理成员变量上的Annotation
          if (f.getKind() == ElementKind.FIELD) {
            Id id = f.getAnnotation(Id.class);
            // 如果id Annotation不为空
            if (id != null) {
              // 执行输出
              ps.println(
                  "		<id name=\""
                      + f.getSimpleName()
                      + "\" column=\""
                      + id.column()
                      + "\" type=\""
                      + id.type()
                      + "\">");
              ps.println("			<generator class=\"" + id.generator() + "\"/>");
              ps.println("		</id>");
            }
            // 获取指定FieldDeclaration前面的Property annotation
            Property p = f.getAnnotation(Property.class);
            // 如果p Annotation不为空
            if (p != null) {
              // 执行输出
              ps.println(
                  "		<property name=\""
                      + f.getSimpleName()
                      + "\" column=\""
                      + p.column()
                      + "\" type=\""
                      + p.type()
                      + "\"/>");
            }
          }
        }
        ps.println("	</class>");
        ps.println("</hibernate-mapping>");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (ps != null) {
        try {
          ps.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

    return true;
  }
}
