package heip.generator.entity;


import java.util.ArrayList;
import java.util.List;

public class EntityTable {
		private String tableName;
		private String fkColumn;
		private List<EntityTable> subEntitys=new ArrayList<EntityTable>();
		//private String cnName;
		
		/**
		 * 
		 * @param tableName 单表
		 */
		public EntityTable(String tableName){
			this.tableName = tableName;
		}
		
		/**
		 * 新建主表对象
		 * @param tableName
		 * @param subEntitys 单表不设置
		 */
		public EntityTable(String tableName,EntityTable... subEntitys){
			this.tableName = tableName;
			if(subEntitys!=null&&subEntitys.length>0){
				for(EntityTable en:subEntitys){
					this.subEntitys.add(en);
				}
			}
		}
		
		
		/**
		 * 新建子表对象
		 * @param tableName 
		 * @param fkColumn 外键 关联父表的字段
		 * @param subEntitys 子表list，如果没有NULL
		 */
		public EntityTable(String tableName,String fkColumn,EntityTable... subEntitys){
			this.tableName = tableName;
			this.fkColumn = fkColumn;
			if(subEntitys!=null&&subEntitys.length>0){
				for(EntityTable en:subEntitys){
					this.subEntitys.add(en);
				}
			}
		}
		
		
		public boolean hasSubTable(){return subEntitys!=null&&!subEntitys.isEmpty();}
		public List<EntityTable> getSubEntitys() {return subEntitys;}
		
		public String getTableName() {return tableName;}
		public String getFkColumn() {return fkColumn;}
}
