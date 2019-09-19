package genClassUtils;

public class ClazzBuilder {

	private Clazz clazz = new Clazz();

	public ClazzBuilder(String clazzName) {
		this.clazz.setClassName(clazzName);
	}

	public ClazzBuilder addField(Field field) {
		this.clazz.getFieldSet().add(field);
		return this;
	}

	public ClazzBuilder addMethod(Method method) {
		this.clazz.getMethodSet().add(method);
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
	

}
