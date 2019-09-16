package genClassUtils;

public class Field implements AutoGen, IsFinalCheck, IsStaticCheck {

	private DataType dataType = DataType.STRING;

	private AccessLevel accessLevel = AccessLevel.PRIVATE;

	private String fieldName;

	private Boolean isFinal = false;

	private Boolean isStatic = false;

	public Field(String fieldName) {
		this.fieldName = fieldName;
	}

	public Field(String fieldName, DataType dataType) {
		this.fieldName = fieldName;
		this.dataType = dataType;
	}

	public Field(String fieldName, DataType dataType, AccessLevel accessLevel) {
		this.fieldName = fieldName;
		this.dataType = dataType;
		this.accessLevel = accessLevel;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setFieldType(DataType dataType) {
		this.dataType = dataType;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Override
	public Boolean getIsStatic() {
		return isStatic;
	}

	@Override
	public void setIsStatic(Boolean isStatic) {
		this.isStatic = isStatic;
	}

	@Override
	public String genCode() {
		StringBuilder fieldBuilder = new StringBuilder();
		fieldBuilder.append(changeLineAndSpace + this.accessLevel.getAccLevelText() + emptySpace);
		if (this.isStatic)
			fieldBuilder.append("static ");
		if (this.isFinal)
			fieldBuilder.append("fianl ");
		fieldBuilder.append(GenStringUtil.firstToUpper(this.dataType.getDataType()) + emptySpace
				+ GenStringUtil.firstToLower(fieldName));
		fieldBuilder.append(";");
		fieldBuilder.append(changeLine);
		return fieldBuilder.toString();
	}

	@Override
	public Boolean getIsFinal() {
		return isFinal;
	}

	@Override
	public void setIsFinal(Boolean isFinal) {
		this.isFinal = isFinal;
	}

}