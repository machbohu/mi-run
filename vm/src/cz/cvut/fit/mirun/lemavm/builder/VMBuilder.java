package cz.cvut.fit.mirun.lemavm.builder;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import cz.cvut.fit.mirun.lemavm.core.VMUtils;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMField;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMVisibilityModifier;

public abstract class VMBuilder {
	public abstract void build() throws RecognitionException;
	public abstract VMCodeBlock getCodeBlock();
	
	protected String buildTypeFromTree(CommonTree node){
		if(node.getChild(0).getChildCount() == 0){
			return node.getChild(0).toString();
		}else{
			return node.getChild(0).getChild(0).toString();
		}
	}
	
	/**
	 * Read variable structure from given node and return list of VMField
	 * @param node
	 * @param caller - Object, that calls this method
	 * @return List of VMField
	 */
	protected List<VMField> buildVarFromTree(CommonTree node, Object caller){
		List<VMField> fields = new ArrayList<>();
		CommonTree child = null;
		VMVisibilityModifier visibility = VMVisibilityModifier.getDefault();
		boolean isStatic = false;
		String type = null, name = null, strVal = null;
		Object val = null;
		
		for(Object o : node.getChildren()){
			child = (CommonTree) o;
			
			switch(child.toString()){
			case "MODIFIER_LIST":
				if(child.getChildCount() > 0){
					visibility = VMVisibilityModifier.fromString(child.getChild(0).toString());
					isStatic = (child.getChildren().indexOf("static") != -1);
				}
				break;
			case "TYPE":
				type = buildTypeFromTree(child);
				break;
			// TODO support for expressions like int a = 5 + 5 * 8;
			case "VAR_DECLARATOR_LIST":
				for(Object o1 : child.getChildren()){
					child = (CommonTree) o1;
					if(child.toString().equals("VAR_DECLARATOR") && child.getChildCount() == 2){
						name = child.getChild(0).toString();
						try{
							strVal = child.getChild(1).getChild(0).toString();
							val = VMUtils.getTypeProperValue(type, strVal);
						}catch(NumberFormatException e){
							throw new VMParsingException("Can not assign value '"+strVal+
									"' to the type '"+type+"' in class '"+caller.toString()+"'");
						}catch(ParseException e1){
							throw new VMParsingException("Can not assign value '"+strVal+
									"' to the type '"+type+"' in class '"+caller.toString()+"'");
						}
					}else if(child.toString().equals("VAR_DECLARATOR") && child.getChildCount() == 1){
						name = child.getChild(0).toString();
						val = VMUtils.getTypeDefaultValue(type);
					}else{
						throw new VMParsingException("Unexpected program syntax '"+child.toString()+
								"' in class '"+caller.toString()+"'");
					}
					fields.add(new VMField(name, isStatic, visibility, type, val));
				}
				break;
			default:
				throw new VMParsingException(
						"Unexpected program syntax '"+child.toString()+"' in class '"+caller.toString()+"'");
			}
		}
		
		return fields;
	}
}
