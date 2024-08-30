import pandas as pd
# Adding sample data to demonstrate the formulas
sample_data = {
    "Date of Transaction": ["2023-08-01", "2023-08-02"],
    "Stock Symbol": ["AAPL", "MSFT"],
    "Transaction Type": ["Buy", "Sell"],
    "Quantity": [10, 5],
    "Price per Share": [150, 280],
    "Total Amount": [1500, 1400],  # Placeholder for formulas
    "Brokerage Fees": [10, 15],
    "Net Amount": [1490, 1385],  # Placeholder for formulas
    "Notes": ["Initial purchase", "Profit taking"]
}

# Create a DataFrame using the sample data
stock_sales_df = pd.DataFrame(sample_data)


# Save the DataFrame to an Excel file with formulas applied to entire columns
file_path_with_formulas_full = './Files/Stock_Sales_Template_with_Formulas_Full.xlsx'
with pd.ExcelWriter(file_path_with_formulas_full, engine='xlsxwriter') as writer:
    stock_sales_df.to_excel(writer, index=False, sheet_name='Stock Sales')

    # Access the XlsxWriter workbook and worksheet objects
    workbook  = writer.book
    worksheet = writer.sheets['Stock Sales']

    # Define a header format with background color and bold text
    header_format = workbook.add_format({'bold': True, 'bg_color': '#D9EAD3', 'border': 1})
    for col_num, value in enumerate(stock_sales_df.columns.values):
        worksheet.write(0, col_num, value, header_format)

    # Set column widths for better visibility
    worksheet.set_column('A:I', 18)

    # Apply Excel formulas for total and net amounts across the entire column (dynamic for all rows)
    row_count = len(stock_sales_df.index)
    for row in range(1, row_count + 1):
        # Formula for Total Amount
        worksheet.write_formula(f'F{row + 1}', f'=D{row + 1}*E{row + 1}')
        # Formula for Net Amount
        worksheet.write_formula(f'H{row + 1}', f'=F{row + 1}-G{row + 1}')

file_path_with_formulas_full

