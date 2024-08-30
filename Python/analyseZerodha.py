import pandas as pd
import matplotlib.pyplot as plt

# Load the report data from the Excel file
report_file_path = './Files/Zerodha_Stock_Sales_Report.xlsx'
report_df = pd.read_excel(report_file_path)

# Convert 'Posting Date' to datetime for better time series handling
report_df['Posting Date'] = pd.to_datetime(report_df['Posting Date'])

# Group data for analysis

# Resample data by 'ME' (month-end) frequency and sum only numeric columns
monthly_summary = report_df.resample('ME', on='Posting Date').sum(numeric_only=True)

# Sum only numeric columns in category summary
category_summary = report_df.groupby('Category').sum(numeric_only=True)

# Plot total debits and credits by month
plt.figure(figsize=(12, 6))
plt.plot(monthly_summary.index, monthly_summary['Debit'], label='Total Debits', marker='o')
plt.plot(monthly_summary.index, monthly_summary['Credit'], label='Total Credits', marker='o')
plt.title('Monthly Total Debits and Credits')
plt.xlabel('Month')
plt.ylabel('Amount')
plt.legend()
plt.grid(True)
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()

# Plot total amounts by category
plt.figure(figsize=(8, 6))
category_summary[['Debit', 'Credit']].plot(kind='bar', stacked=True)
plt.title('Total Debits and Credits by Category')
plt.xlabel('Category')
plt.ylabel('Amount')
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()

# Plot net balance trend over time
plt.figure(figsize=(12, 6))
plt.plot(report_df['Posting Date'], report_df['Net Balance'], label='Net Balance', marker='o')
plt.title('Net Balance Over Time')
plt.xlabel('Date')
plt.ylabel('Net Balance')
plt.grid(True)
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()

# Plot transaction counts by category
transaction_counts = report_df['Category'].value_counts()
plt.figure(figsize=(8, 6))
transaction_counts.plot(kind='pie', autopct='%1.1f%%', startangle=140)
plt.title('Transaction Distribution by Category')
plt.ylabel('')
plt.tight_layout()
plt.show()
