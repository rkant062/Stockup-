import pandas as pd
from datetime import datetime

def longestRide(df):
    df['pickup_datetime'] = pd.to_datetime(df['pickup_datetime'])
    df['dropoff_datetime'] = pd.to_datetime(df['dropoff_datetime'])
    
    df.dropna(subset=['pickup_datetime', 'dropoff_datetime'], inplace=True)
    
    df['duration'] = df['dropoff_datetime'] - df['pickup_datetime']
    
    df['pickup_month'] = df['pickup_datetime'].dt.to_period('M')
    
    result = df.loc[df.groupby('pickup_month')['duration'].idxmax()]
    
    result.sort_values('pickup_month', inplace=True)
    
    result = result[['pickup_month', 'id']]
    
    result['pickup_month'] = result['pickup_month'].dt.strftime('%Y-%m')
    
    return result

data = {
    'id': ['id0219696', 'id1372182', 'id3569980', 'id2858528'],
    'vendor_id': [72, 80, 69, 29],
    'pickup_datetime': ['2016-06-06 06:06:20', '2016-02-07 19:18:49', '2016-06-14 00:26:11', None],
    'dropoff_datetime': ['2016-06-06 06:13:34', '', '2016-06-14 00:34:09', '']
}
df = pd.DataFrame(data)

print(longestRide(df))
