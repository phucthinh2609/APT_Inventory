class App {

    static DOMAIN = location.origin;

    static BASE_URL = this.DOMAIN + "/api";

    static SweetAlert = class {
        static showSuccessAlert(t) {
            Swal.fire({
                icon: 'success',
                title: t,
                position: 'top-end',
                showConfirmButton: false,
                timer: 1500
            })
        }

        static showErrorAlert(t) {
            Swal.fire({
                icon: 'error',
                title: 'Warning',
                text: t,
            })
        }
    }

    static renderProduct(obj) {
        let str = `
            <tr id="tr_${obj.id}">
                <td>${obj.id}</td>
                <td>${obj.name}</td>
                <td>${obj.price}</td>
                <td>
                    <button class="btn btn-outline-success detail" data-id="${obj.id}">Detail</button>
                </td>
                <td>
                    <button class="btn btn-outline-secondary edit" data-id="${obj.id}">Update</button>
                </td>
            </tr>
        `;

        return str;
    }

    static renderDetailTableRow(obj) {
        let str = `
            <tr>
                <td class="col-lg-3 fw-bold">${obj.explanation}</td>
                <td class="col-lg-9" style="text-align: justify;">${obj.content}</td>
            </tr>
        `;

        return str;
    }

    static renderInputCreateForm(obj) {
        let str = `
            <div class="col-lg-6 fl mt-3">
                <label class="form-label fw-bold">${obj.name}</label>
            ${obj.multiline
                ? `<textarea class="form-control" id="${obj.name}" data-name="${obj.name}" data-explanation="${obj.explanation}" rows="1" style="resize: none;"></textarea>`
                : `<input type="text" class="form-control" id="${obj.name}" data-name="${obj.name}" data-explanation="${obj.explanation}">`
            }
            </div>
        `;

        return str;
    }

    static renderInputUpdateForm(key, value, multiline) {
        let str = `
            <div class="col-lg-6 fl mt-3">
                <label class="form-label fw-bold">${value}</label>
            ${multiline
                ? `<textarea class="form-control" id="${key}" data-name="${key}" data-explanation="${value}" rows="2" style="resize:none;"></textarea>`
                : `<input type="text" class="form-control" id="${key}" data-name="${key}" data-explanation="${value}">`
            }
            </div>
        `;

        return str;
    }
}