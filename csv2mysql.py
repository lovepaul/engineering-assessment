import pandas as pd
from sqlalchemy import create_engine

# 配置数据库连接信息
db_username = 'root'  # 替换为你的数据库用户名
db_password = '521521'  # 替换为你的数据库密码
db_host = '43.247.134.59'  # 数据库地址
db_port = '3306'  # 数据库端口
db_name = 'food'  # 数据库名称
table_name = 'mobile_food_facility_permit'  # 表名称

# 创建数据库引擎
engine = create_engine(f'mysql+pymysql://{db_username}:{db_password}@{db_host}:{db_port}/{db_name}')

# 读取 CSV 文件
csv_file_path = '/Users/yang/Downloads/Mobile_Food_Facility_Permit.csv'
df = pd.read_csv(csv_file_path)

# 重命名列以匹配数据库表的字段名称
df.columns = [
    'location_id', 'applicant', 'facility_type', 'cnn', 'location_description',
    'address', 'blocklot', 'block', 'lot', 'permit', 'status', 'food_items',
    'x', 'y', 'latitude', 'longitude', 'schedule', 'days_hours', 'noi_sent',
    'approved', 'received', 'prior_permit', 'expiration_date', 'location',
    'fire_prevention_districts', 'police_districts', 'supervisor_districts',
    'zip_codes', 'neighborhoods_old'
]

# 更新日期格式以正确解析 "03/28/2024 12:00:00 AM"
df['approved'] = pd.to_datetime(df['approved'], format='%m/%d/%Y %I:%M:%S %p', errors='coerce')
df['expiration_date'] = pd.to_datetime(df['expiration_date'], format='%m/%d/%Y %I:%M:%S %p', errors='coerce')
df['received'] = pd.to_datetime(df['received'], format='%Y%m%d', errors='coerce')

# 数据导入 MySQL 数据库
try:
    df.to_sql(table_name, con=engine, if_exists='replace', index=False, chunksize=1000, method='multi')
    print(f"数据成功导入到表 {table_name} 中")
except Exception as e:
    print(f"数据导入失败: {e}")