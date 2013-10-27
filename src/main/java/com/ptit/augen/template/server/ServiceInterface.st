package $packageName$.business;

import java.util.List;
import $packageName$.entity.$tableName$;

/**
 * User: Nguyen Tuan Anh
 * Company: QSoftVietNam
 * Dev: JAVA
 */

public interface $tableName$Service {

	public $tableName$ findById(Long id);

	public void save($tableName$ _$tableName$);

	public void remove($tableName$ _$tableName$);

	public void remove(Long id);

	public List<$tableName$> getAll();
}
