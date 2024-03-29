package genClassUtils;

import java.util.Set;

import genClassUtils._interface.Interface;
import genClassUtils.annotation.ClazzAnnotation;
import genClassUtils.field.Field;
import genClassUtils.method.ClazzMethod;

public class ClazzBuilder {

	private Clazz clazz = new Clazz();

	public ClazzBuilder(String clazzName) {
		this.clazz.setClassName(clazzName);
	}

	public ClazzBuilder setPackageName(String packageName) {
		this.clazz.setPackageName(packageName);
		return this;
	}
	
	public ClazzBuilder setImports(Set<String> imports) {
		this.clazz.setImports(imports); 
		return this;
	}

	public ClazzBuilder addField(Field field) {
		this.clazz.getFieldSet().add(field);
		return this;
	}

	public ClazzBuilder addMethod(ClazzMethod method) {
		this.clazz.getMethodSet().add(method);
		return this;
	}

	public ClazzBuilder addAnnotation(ClazzAnnotation annotation) {
		this.clazz.getAnnotation().add(annotation);
		return this;
	}

	public ClazzBuilder addGeneric(String genericType) {
		this.clazz.isSupportGeneric = true;
		this.clazz.getGenerics().add(genericType);
		return this;
	}

	public ClazzBuilder addGeneric(Set<String> genericTypes) {
		this.clazz.isSupportGeneric = true;
		this.clazz.getGenerics().addAll(genericTypes);
		return this;
	}

	public ClazzBuilder addImplementInterfaces(Interface interfaceImpl) {
		this.clazz.getImplementInterfaces().add(interfaceImpl);
		return this;
	}

	public ClazzBuilder addGetter(Field field) {
		this.clazz.addGetter(field);
		return this;
	}

	public ClazzBuilder addSetter(Field field) {
		this.clazz.addSetter(field);
		return this;
	}

	public ClazzBuilder addGetterSetter(Field field) {
		this.clazz.addGetterSetter(field);
		return this;
	}

	public Clazz buildClazz() {
		return this.clazz;
	}

	public ClazzBuilder buildGetterSetter(Field field) {
		addField(field);
		addGetterSetter(field);
		return this;
	}

	public ClazzBuilder buildAllGetterSetter(Set<Field> fields) {
		fields.stream().forEach(field -> {
			addField(field);
			addGetterSetter(field);
		});
		return this;
	}
}
