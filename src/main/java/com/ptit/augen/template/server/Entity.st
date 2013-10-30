package $packageName$.entity;

import javax.persistence.*;
import java.util.*;

/**
 * User: Nguyen Tuan Anh
 * Company: QSoftVietNam
 * Dev: JAVA
 */

@Entity
@Table(name = "$tableName$")
public class $tableName$  implements Comparable
{$fields:{ field |
    $if(field.IsKey)$
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    $endif$
    @Column(name = "$field.FieldName$")
    private $field.ServerFieldType$ $field.FieldName$;

    public void set$field.FieldName$($field.ServerFieldType$ $field.FieldName$)
    {
        this.$field.FieldName$ = $field.FieldName$;
    }

    public $field.ServerFieldType$ get$field.FieldName$()
    {
        return $field.FieldName$;
    }
    }$

    @Override
    public int compareTo(Object object)
    {
        return (int)(this.id - (($tableName$)object).getid());
    }

    @Override
    public String toString()
    {
        return this.id.toString();
    }
}
