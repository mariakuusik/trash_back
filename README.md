# trash_back

trash_back is an application that allows user to search for packaging recycling instructions based on UPC code (barcode).

Users can search for information without logging in.
Log-in feature is for companies that can add their products (packaging) and admin who controls companies activation.

The original version's scope 1 was built as a group project in September 2023.
This is my modified version.

## current features in back-end
In back-end, there are currently five controller classes with associated service classes:
- ProductsController - add, return and change products
- ImagesController - add image (admin feature), return image
- ComponentsController - add one component to product, return all components, delete product-component
- RecyclingController - search based on UPC code and bins' information
- MaterialsController - return all materials

## upcoming features in back-end
- working on database model to make sure it answers to all business model requirements
- deleting products
- working on all the features associated with recycling (especially search function)
- creating an image database where companies can choose an image that represents their product packaging
- adding new Companies (admin feature)
- activating or deactivating companies (admin feature)
- logging in (Company)
- logging in (Admin)



