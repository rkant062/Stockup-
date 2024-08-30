import pandas as pd

# Load the CSV file
ledger_df = pd.read_csv('./Zerodha/ledger-UM9226.csv')

# Helper functions
def extract_period(description):
    description_lower = description.lower()
    if "delayed payment charges" in description_lower:
        parts = description_lower.split('for')
        if len(parts) > 1:
            return parts[1].strip()
    return ""

def extract_company(description):
    description_lower = description.lower()
    if "dp charges for sale of" in description_lower:
        start = description_lower.find("sale of") + 8  # Offset to get text after 'sale of '
        end = description_lower.find("on") if "on" in description_lower else len(description_lower)
        return description_lower[start:end].strip().upper()
    return ""

def categorize_transaction(description):
    description_lower = description.lower()
    if "delayed payment charges" in description_lower:
        return "Platform Cost"
    elif "dp charges for sale of" in description_lower:
        return "Sale"
    elif "f&0" in description_lower:
        return "Futures and Options"
    elif "net" in description_lower:
        return "Net Settlement or Obligation"
    elif "withdrawal" in description_lower:
        return "Withdrawal"
    elif "funds added" in description_lower:
        return "Deposit"
    else:
        return "Other"

# Apply the functions to create new columns
ledger_df['Period'] = ledger_df['particulars'].apply(extract_period)
ledger_df['Company'] = ledger_df['particulars'].apply(extract_company)
ledger_df['Category'] = ledger_df['particulars'].apply(categorize_transaction)

# Display a sample of the DataFrame including the new 'Transaction Date' and financial columns
output_columns = ['particulars', 'posting_date', 'Period', 'Company', 'Category', 'debit', 'credit']
filtered_df = ledger_df[output_columns]
filtered_df[output_columns]

print(filtered_df)
updated_ledger_path = './../Files/Updated_Ledger.xlsx'
filtered_df.to_excel(updated_ledger_path, index=False)