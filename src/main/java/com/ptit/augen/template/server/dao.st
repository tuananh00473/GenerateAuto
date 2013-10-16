/** 
* Created by Generate Code Tool. 
* Author: Le Hoang Hai - QsoftVietNam
* Coder: Nguyen Tuan Anh - QsoftVietNam
*/ 
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using HoangHai.Models;
using System.Data.SqlClient;

namespace HoangHai.DataAccess
{
    public class $tableName$DA : BaseDAO
    {        
        #region Methods
        /// <summary>
        /// Method responsible to insert $tableName$ objects into the database
        /// </summary>
        /// <param name="$tableName$"></param>
        /// <returns></returns>
        public int Add($tableName$ record)
        {
            conn = new SqlConnection(connectionString);
            var newId = 0;
            try
            {
                conn.Open();
                cmd = new SqlCommand("insert into [$tableName$]($fields:{ field | [$field.FieldName$]};separator=","$) OUTPUT INSERTED.Id values($fields:{ field | @$field.FieldName$};separator=","$)", conn);
                $fields:{ field | cmd.Parameters.AddWithValue("@$field.FieldName$", record.$field.FieldName$);};separator="\n"$ 				
                newId = int.Parse(cmd.ExecuteScalar().ToString());
            }
            finally
            {
                conn.Close();
            }
            return newId;
        }

        /// <summary>
        /// Method responsible to edit $tableName$ objects from a database
        /// </summary>
        /// <param name="$tableName$"></param>
        /// <returns></returns>
        public int Edit($tableName$ record)
        {
            conn = new SqlConnection(connectionString);
            SqlDataReader dr = null;
            try
            {
                conn.Open();
                cmd = new SqlCommand("update [$tableName$] set $fields:{ field | [$field.FieldName$] = @$field.FieldName$};separator=","$ where Id = @Id;", conn);
                cmd.Parameters.AddWithValue("@Id", record.Id);
				$fields:{ field | cmd.Parameters.AddWithValue("@$field.FieldName$", record.$field.FieldName$);};separator="\n"$

                dr = cmd.ExecuteReader();
                var t = new CastDbType<$tableName$>();
                if (dr.HasRows)
                {
                    record = t.Fill(dr)[0];
                }
            }
            finally
            {
                if (dr != null && !dr.IsClosed)
                {
                    dr.Close();
                }
                conn.Close();
            }
            return record.Id;
        }

        /// <summary>
        /// Method responsible to $tableName$ objects from a database
        /// </summary>
        /// <param name="Id"></param>
        /// <returns></returns>
        public $tableName$ Get(int Id)
        {
            conn = new SqlConnection(connectionString);
            SqlDataReader dr = null;
            List<$tableName$> lstReturn = new List<$tableName$>();
            try
            {
                conn.Open();
                cmd = new SqlCommand("select * from [$tableName$] where Id = @Id;", conn);
                cmd.Parameters.AddWithValue("@Id", Id);

                dr = cmd.ExecuteReader();
                var t = new CastDbType<$tableName$>();
                if (dr.HasRows)
                {
                    lstReturn = t.Fill(dr).ToList<$tableName$>();
                }
            }
            finally
            {
                if (dr != null && !dr.IsClosed)
                {
                    dr.Close();
                }
                conn.Close();
            }
            return lstReturn.FirstOrDefault();
        }

		/// <summary>
        /// Method responsible to list $tableName$ objects from a database
        /// </summary>
        /// <returns></returns>
        public List<$tableName$> GetAll()
        {
            conn = new SqlConnection(connectionString);
            SqlDataReader dr = null;
            List<$tableName$> lstReturn = new List<$tableName$>();
            try
            {
                conn.Open();
                cmd = new SqlCommand("select * from [$tableName$];", conn);

                dr = cmd.ExecuteReader();
                var t = new CastDbType<$tableName$>();
                if (dr.HasRows)
                {
                    lstReturn = t.Fill(dr).ToList<$tableName$>();
                }
            }
            finally
            {
                if (dr != null && !dr.IsClosed)
                {
                    dr.Close();
                }
                conn.Close();
            }
            return lstReturn;
        } 
		
		/// <summary>
        /// Method responsible to delete $tableName$ objects from a database
        /// </summary>
        /// <param name="Id"></param>
        /// <returns></returns>
        public void Delete(int Id)
        {

            conn = new SqlConnection(connectionString);
            try
            {
                conn.Open();
                cmd = new SqlCommand("delete from [$tableName$] where Id = @Id;", conn);
                cmd.Parameters.AddWithValue("@Id", Id);


                cmd.ExecuteNonQuery();
            }
            finally
            {
                conn.Close();
            }

        }       
        #endregion
    }
}